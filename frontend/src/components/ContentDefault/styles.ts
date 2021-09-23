import styled, { css } from 'styled-components';

export const ContentContainer = styled.div`
  max-width: 90%;
  height: 100%;
  margin: 0 auto;
  overflow: hidden;
  padding: 0 2rem;
  ${({ theme }) => css`
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;
