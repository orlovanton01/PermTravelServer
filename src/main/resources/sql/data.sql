INSERT INTO public.places (id, name, description, photoPath)
VALUES ('3ea29d2b-74b4-4dfb-b9bc-7df3d67777c5', 'Test', 'Test', 'Test')
ON CONFLICT (id) DO UPDATE
SET
    name = EXCLUDED.name,
    description = EXCLUDED.description;
    photoPath = EXCLUDED.photoPath;